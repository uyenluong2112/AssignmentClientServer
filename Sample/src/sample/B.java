class B extends Thread
{
       public void run()
         {
              for(int j=1;j<=50;j++)
                {
                      System.out.println("\t From ThreadB: j= "+j);
                }
                 System.out.println("Exit from B");
         }
}
