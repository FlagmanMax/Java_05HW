// На шахматной доске расставить 8 ферзей так, 
// чтобы они не били друг друга. 
// И вывести Доску. 0x00000 0000x00 00x0000

import java.util.Stack;

public class HW_05_03
{  
    /**
     * @param args
     */
    public static void main(String[] args) 
    { 
        Stack<Integer[]> queenStack = new Stack<>();

        int i_queenCnt = 0;
        while (i_queenCnt<8)
        {
            for (int i=0;i<8;i++)
            {
                for (int j=0;j<8;j++)
                {
                    if (checkQueen(i,j,queenStack))
                    {
                        Integer[] coord = new Integer[2];
                        coord[0] = i;
                        coord[1] = j;
                        
                        queenStack.add(coord);
                        i_queenCnt++;

                        break;
                    }

                    while((j==7))
                    {
                        Integer[] coord = new Integer[2];
                        coord = queenStack.pop();
                        i_queenCnt--;
                        i = coord[0];
                        j = coord[1];
                    }

                }
            }
            
            Integer[] coord = new Integer[2];
            while(queenStack.size()>0)
            {
                coord = queenStack.pop();
                for (int i=0;i<8;i++)
                {
                    if (coord[1] == i)
                    {
                        System.out.printf("X ");
                    }
                    else
                    {
                        System.out.printf("0 "); 
                    }
                }
                System.out.printf("\n"); 
            }
        }
    }
    
    public static boolean checkQueen(int i, int j, Stack<Integer[]> queenStack)
    {
        boolean result = true;

        Integer[] coordLocal = new Integer[2];
        for (int num=0;num<queenStack.size();num++)
        {
            coordLocal = queenStack.elementAt(num);

            if ((coordLocal[0] == i) || (coordLocal[1] == j)) // only 1 value in a row or column
            {
                result = false;
                return result;
            }
            if (Math.abs(coordLocal[0]-i) == Math.abs(coordLocal[1]-j)) // Check diags
            {
                result = false;
                return result;
            }
        }
        return result;
    }
}