package org.jinlong.study.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nick on 02/01/2017.
 * 有三个和尚和三个妖怪，要利用唯一一只小船过河，小船一次只能承载俩个人，同时无论在岸上或者船上，
 * 只要妖怪个数大于和尚数量，妖怪们就会吃掉和尚。需要选择一种过河安排，保证和尚和妖怪都能过河且
 * 和尚不被妖怪吃掉。
 */
public class CrossRiver {
    static int MONSTER_COUNT = 3;
    private TagAction[] actions = {
            new TagAction(ActionName.ONE_MONSTER_GO, BoatLocation.REMOTE, -1, 0),
            new TagAction(ActionName.TWO_MONSTER_GO, BoatLocation.REMOTE, -2, 0),
            new TagAction(ActionName.ONE_MONK_GO, BoatLocation.REMOTE, 0, -1),
            new TagAction(ActionName.TWO_MONK_GO, BoatLocation.REMOTE, 0, -2),
            new TagAction(ActionName.ONE_MONSTER_ONE_MONK_GO, BoatLocation.REMOTE, -1, -1),
            new TagAction(ActionName.ONE_MONSTER_BACK, BoatLocation.LOCAL, 1, 0),
            new TagAction(ActionName.TWO_MONSTER_BACK, BoatLocation.LOCAL, 2, 0),
            new TagAction(ActionName.ONE_MONK_BACK, BoatLocation.LOCAL, 0, 1),
            new TagAction(ActionName.TWO_MONK_BACK, BoatLocation.LOCAL, 0, 2),
            new TagAction(ActionName.ONE_MONSTER_ONE_MONK_BACK, BoatLocation.LOCAL, 1, 1)
    };


    private static ItemState state = new ItemState(3, 3, 0, 0, BoatLocation.LOCAL);

    private static LinkedList<ItemState> states = new LinkedList<ItemState>();

    public static void main(String[] args) {
        CrossRiver solution = new CrossRiver();
        states.addLast(state);
        solution.searchState(states);
    }

    private void searchState(LinkedList<ItemState> states) {
        ItemState current = states.getLast();
        if (current.isFinalState()) {
            printResult(states);
            return;
        }
        for (int i = 0; i < actions.length; i++) {
            searchStateOnNewAction(states, current, actions[i]);
        }
    }

    private void printResult(LinkedList<ItemState> states) {
        System.out.println("\n************State Start***************");
        Util.printListItems(states);
        System.out.println("************State End***************");
    }

    private boolean isProcessedState(LinkedList<ItemState> states, ItemState next) {
        for (ItemState state : states) {
            if (state.localMonster == next.localMonster && state.localMonk == next.localMonk && state.boat == next.boat) {
                return true;
            }
        }
        return false;
    }

    private void searchStateOnNewAction(LinkedList<ItemState> states, ItemState current, TagAction action) {
        ItemState next = new ItemState(0, 0, 0, 0, BoatLocation.LOCAL);
        if (makeActionNewState(current, action, next)) {
            if (next.isValidState() && !isProcessedState(states, next)) {
                states.addLast(next);
                searchState(states);
                states.removeLast();
            }
        }
    }
    private boolean makeActionNewState(ItemState current, TagAction action, ItemState newState) {
        if (current.canTakeAction(action)) {
            newState.localMonster = current.localMonster;
            newState.localMonk = current.localMonk;
            newState.remoteMonster = current.remoteMonster;
            newState.remoteMonk = current.remoteMonk;
            newState.boat = current.boat;
            newState.currentAction = current.currentAction;
            newState.localMonster += action.getMoveMonster();
            newState.localMonk += action.getMoveMonk();
            newState.remoteMonster -= action.getMoveMonster();
            newState.remoteMonk -= action.getMoveMonk();
            newState.boat = action.getBoatTo();
            newState.currentAction = action.getActionName();
            return true;
        }
        return false;
    }
}
enum BoatLocation {
    LOCAL, REMOTE
}
class ItemState {
    int localMonster;
    int localMonk;
    int remoteMonster;
    int remoteMonk;
    BoatLocation boat;
    ActionName currentAction = ActionName.INVALID_ACTION_NAME;

    @Override
    public String toString() {
        return currentAction.toString();
    }

    boolean canTakeAction(TagAction action) {
        if (boat == action.getBoatTo()) {
            return false;
        }
        if (localMonster + action.getMoveMonster() < 0 || localMonster + action.getMoveMonster() > CrossRiver.MONSTER_COUNT) {
            return false;
        }
        if (localMonk + action.getMoveMonk() < 0 || localMonk + action.getMoveMonk() > CrossRiver.MONSTER_COUNT) {
            return false;
        }
        return true;
    }

    boolean isValidState() {
        if (localMonk > CrossRiver.MONSTER_COUNT || localMonster > CrossRiver.MONSTER_COUNT
                || remoteMonk > CrossRiver.MONSTER_COUNT || remoteMonster > CrossRiver.MONSTER_COUNT) {
            return false;
        }
        if (localMonk + remoteMonk > CrossRiver.MONSTER_COUNT) {
            return false;
        }
        if (localMonster + remoteMonster > CrossRiver.MONSTER_COUNT) {
            return false;
        }
        if (((localMonster > localMonk) && (localMonk > 0)) || ((remoteMonster > remoteMonk) && (remoteMonk > 0))) {
            return false;
        }
        return true;
    }

    boolean isFinalState() {
        if (remoteMonster == CrossRiver.MONSTER_COUNT && (remoteMonster == remoteMonk)) {
            return true;
        }
        return false;
    }

    public ItemState(int localMonster, int localMonk, int remoteMonster, int remoteMonk, BoatLocation boat) {
        this.localMonster = localMonster;
        this.localMonk = localMonk;
        this.remoteMonster = remoteMonster;
        this.remoteMonk = remoteMonk;
        this.boat = boat;
    }
}
enum ActionName {
    ONE_MONSTER_GO,
    TWO_MONSTER_GO,
    ONE_MONK_GO,
    TWO_MONK_GO,
    ONE_MONSTER_ONE_MONK_GO,
    ONE_MONSTER_BACK,
    TWO_MONSTER_BACK,
    ONE_MONK_BACK,
    TWO_MONK_BACK,
    ONE_MONSTER_ONE_MONK_BACK,
    INVALID_ACTION_NAME,
}
class TagAction {
    private ActionName actionName;
    private BoatLocation boatTo;
    private int moveMonster;
    private int moveMonk;

    @Override
    public String toString() {
        return actionName.toString();
    }

    public TagAction(ActionName actionName, BoatLocation boatTo, int moveMonster, int moveMonk) {
        this.actionName = actionName;
        this.boatTo = boatTo;
        this.moveMonster = moveMonster;
        this.moveMonk = moveMonk;
    }

    public ActionName getActionName() {
        return actionName;
    }

    public void setActionName(ActionName actionName) {
        this.actionName = actionName;
    }

    public BoatLocation getBoatTo() {
        return boatTo;
    }

    public void setBoatTo(BoatLocation boatTo) {
        this.boatTo = boatTo;
    }

    public int getMoveMonster() {
        return moveMonster;
    }

    public void setMoveMonster(int moveMonster) {
        this.moveMonster = moveMonster;
    }

    public int getMoveMonk() {
        return moveMonk;
    }

    public void setMoveMonk(int moveMonk) {
        this.moveMonk = moveMonk;
    }
}
