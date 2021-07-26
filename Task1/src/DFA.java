
public class DFA {
	//accepted states
    static String [] accepted;
    //initial state of dfa
    final static String initialState = "0";
    //States
    static String[] states;
    //Transition between states 
    static String [] transition;
    //Symbols in the program
    final int [] symbols = {0,1};
	
 public DFA (String dfa) {
	 String [] subDfa = dfa.split("\\#");
	 String [] subTransition = dfa.split("\\#",0);
	 transition = subTransition[0].split(";");
	 accepted = subDfa[subDfa.length-1].split(",");
	 states = new String [(transition.length)];
	 int j=0;
	 for (int i = 0 ; i < transition.length ;i= i+1) 
	 {
		 states[j]= "" + transition[i].charAt(0);
		 j++;
	 }
 }
 public static boolean Run(String x) {
	 boolean accept = false;    
	 int k = 0;
	 String element ="";
	 int position =0;
	 if (!(states[0].equals(initialState)))
	      return false;
	 else 
	 {
		for (int i = 0 ; i< x.length() ;i++)
		{
		     if(i==0)
		     {
		    	 if (x.charAt(i)=='0') 
		    	 {
		    		 element = ""+transition[0].charAt(2);
		    	 }
		    	 else if (x.charAt(i)=='1')
		    	 {
		    		 element = ""+transition[0].charAt(4);
		    	 }
		     }
		     else if ( i == x.length()-1)
		     {
		    	 if (x.charAt(i)=='0') 
		    	 {
		    		 position = search(element);
		    		 element = ""+transition[position].charAt(2);
		    		 accept = checkGoal(element);
		    	 }
		    	 else if (x.charAt(i)=='1')
		    	 {
		    		 position = search(element);
		    		 element = ""+transition[position].charAt(4);
		    		 accept = checkGoal(element);
		    	 }
		     }
		     else 
		     {
		    	 if (x.charAt(i)=='0') 
		    	 {
		    		 position = search(element);
		    		 element = ""+transition[position].charAt(2);
		    	 }
		    	 else if (x.charAt(i)=='1')
		    	 {
		    		 position = search(element);
		    		 element = ""+transition[position].charAt(4);
		    	 }
		     }
		}
	 }
	return accept;
	 
 }
 
 public static boolean checkGoal(String x)
{
   for (int i = 0 ; i < accepted.length ; i++) {
	   if (accepted[i].equals(x))
		   return true;
   }
   return false;
}
 public static int search(String x) 
 {   
	 int j = 0;
	 for (int i = 0 ; i < states.length ; i++) {
		 if (states[i].equals(x)) {
			 j = i;
		 }	
	 }
	 return j;
 }
	
	
	
public static void main(String[] args) {
//		
//		String ab = "0,2,1;1,1,2;2,3,4;3,4,3;4,5,5;5,5,5#3,5";
//		
//		DFA a = new DFA(ab);
//		System.out.println(Run("10000100"));
//		System.out.println(Run("010100010110"));
//		System.out.println(Run("10000101110"));
//		System.out.println(Run("101011111"));
//		System.out.println(Run("1001001110"));
//		
		String cd = "0,0,1;1,2,3;2,3,0;3,3,4;4,2,5;5,5,5#1,2,5";
		DFA b = new DFA(cd);
		System.out.println(Run("0000110011"));
		System.out.println(Run("010110"));
		System.out.println(Run("1011010"));
		System.out.println(Run("11100101"));
		System.out.println(Run("1010101"));
	}

}
