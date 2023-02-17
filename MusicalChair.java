import java.util.*;

public class MusicalChair{
    
    MusicalChair(){

    }

    public int getWinnerIndex( String[] contestants, int[] songStopInSec){
        
        int rem = contestants.length;

        int idx_cont = 0;
        int idx_sec = 0; 
        int cnt=0;
        while(rem>1){

            idx_cont = (idx_cont+1)%contestants.length;    

            if(contestants[idx_cont]!=null){
                cnt++;
            }
            if(cnt==songStopInSec[idx_sec]){
                System.out.println("Contestant: "+contestants[idx_cont]+" at index:"+idx_cont+" has been eliminated");
                contestants[idx_cont]=null;
                cnt=-1;
                rem--;
                idx_sec = (idx_sec + 1)%songStopInSec.length;
            }
            if(rem==1)
                break;
            
        }

        int res=-1;
        for(int i=0; i<contestants.length; i++){
            if(contestants[i]!=null){
                res=i;
                break;
            }
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of contestants");
        int n = sc.nextInt();
        sc.nextLine();
        String[] contestants = new String[n];
        for(int i=0; i<n; i++){
            contestants[i] = sc.nextLine();
        }

        int[] songStopInSec = {3,1,1};

        MusicalChair mc = new MusicalChair();
        int winnerIndex = mc.getWinnerIndex( contestants, songStopInSec);
        System.out.println("\nWinner: "+contestants[winnerIndex]+"\nIndex of Winner: "+ winnerIndex);

        sc.close();

    }
}