
class ThreadTest
{
          public static void main(String args[])
           {
        	  A threadA=new A();
        	  B threadB=new B();
        	  C threadC=new C();
              threadC.setPriority(Thread.MAX_PRIORITY);
              threadB.setPriority(threadA.getPriority()+1);
              threadA.setPriority(Thread.MIN_PRIORITY);

                   threadA.start();
                   threadB.start();
                   threadC.start();
           }
}
