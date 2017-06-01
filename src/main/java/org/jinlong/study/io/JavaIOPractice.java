package org.jinlong.study.io;

/**
 * Created by nick on 01/06/2017.
 *
 * I/O 指的是 Input 和 Output，Java I/O 主要关注如何从源处读取数据到目的地。最典型的数据的源和目的地有如下：
 *  1。 Files
 *  2。 Pipes
 *  3。 Network Connections
 *  4。 In-memory buffers， arrays
 *  5。 System.in， System.out， System.error
 *
 * 流是Java I/O的核心概念，它指的是数据流的概念，链接到数据原始处或者目的地。Java中有2中类型的流，字节流和字符流。
 * 如果我们要读取数据，我们需要有输入字节流InputStream或者字符流Reader；如果我们要输出数据，我们需要有输出字节流 OutputStream
 * 或者 字符流Writer。
 *
 * Java提供了大量的字符流和字节流的实现类，他们的目的是什么呢？
     File Access
     Network Access
     Internal Memory Buffer Access
     Inter-Thread Communication (Pipes)
     Buffering
     Filtering
     Parsing
     Reading and Writing Text (Readers / Writers)
     Reading and Writing Primitive Data (long, int etc.)
     Reading and Writing Objects
 *
 * Java I/O 实现类概览
**************************************************************************************************************************
**  	             *   Byte    Based 	      *                       *  Character Based
*                    *   Input 	              *  Output 	          *     Input 	         *      Output
**************************************************************************************************************************
*Basic 	             *   InputStream 	      *  OutputStream 	      * Reader               *  Writer
*                    *                        *                       *   InputStreamReader *	    OutputStreamWriter
**************************************************************************************************************************
*Arrays 	         *   ByteArrayInputStream *	ByteArrayOutputStream *	CharArrayReader 	 *  CharArrayWriter
**************************************************************************************************************************
*Files 	             *   FileInputStream      *   FileOutputStream    *   FileReader 	     *      FileWriter
*                    *   RandomAccessFile     *   RandomAccessFile
**************************************************************************************************************************
*Pipes 	             *   PipedInputStream 	  *  PipedOutputStream 	  * PipedReader 	     *  PipedWriter
**************************************************************************************************************************
*Buffering 	         *   BufferedInputStream  *  BufferedOutputStream *	BufferedReader 	     *  BufferedWriter
**************************************************************************************************************************
*Filtering 	         *   FilterInputStream 	  *  FilterOutputStream  *	    FilterReader 	 *      FilterWriter
**************************************************************************************************************************
*Parsing 	         *   PushbackInputStream  *                       *   PushbackReader
*                    *   StreamTokenizer      *                       *   LineNumberReader
**************************************************************************************************************************
*Strings 	  	  	 *                        *                       *   StringReader 	     *  StringWriter
**************************************************************************************************************************
*Data 	             *   DataInputStream 	  *  DataOutputStream
**************************************************************************************************************************
*Data - Formatted 	 * 	                      *  PrintStream 	  	  *                      *  PrintWriter
**************************************************************************************************************************
*Objects 	         *   ObjectInputStream 	  *  ObjectOutputStream   *
************************************************************************************************************************
*Utilities 	            SequenceInputStream
************************************************************************************************************************
 *
 */
public class JavaIOPractice {
}
