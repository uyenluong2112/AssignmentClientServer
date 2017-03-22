class C extends Thread
{
       public void run()
         {
              for(int k=1;k<=50;k++)
                {
                      System.out.println("\t From ThreadC: k= "+k);
                }

                 System.out.println("Exit from C");
         }
}
