class A extends Thread
{
       public void run()
         {
              for(int i=1;i<=50;i++)
                {
                      System.out.println("\t From ThreadA: i= "+i);
                }
                 System.out.println("Exit from A");
         }
}
