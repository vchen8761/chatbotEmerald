package groupFiles;


public class GabrielJokes implements Chatbot {
	
	private String jokeChoice;
	private boolean inJokeLoop;
	private String jokeResponse;
	private String[] calm = {"Try again", "Almost there", "You're getting warmer"};
	private String[] aggravated = {"ARE YOU A HATER OF JOKES?", "You're doing this in purpose"};
	
	static int count = 0;
	static int jokeIndex = 0;
	static String[] jokes = {"Amos", "Etch", "Cows go"};
	static String[] jokeAnswers = {"A mosquito", "Bless you", "No silly, cows go moo"};
	
	public boolean isTriggered(String userInput) {
		if(VictorMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk() {
		inJokeLoop = true;
		VictorMain.print("Would you like to hear a joke?");
		getJoke();
		jokeChoice = getJoke();
		findIndexOfJoke(jokeChoice);
		while(inJokeLoop){
			jokeResponse = VictorMain.promptInput();
			jokeResponse = jokeResponse.toLowerCase();
			
			if(VictorMain.findKeyword(jokeResponse, "no", 0)>= 0){
				inJokeLoop = false;
				VictorMain.print("Fine then");
				VictorMain.promptForever();
			}
			else if((VictorMain.findKeyword(jokeResponse, "yeah", 0)>= 0) || (VictorMain.findKeyword(jokeResponse, "yes", 0) >= 0)){
				VictorMain.print("Knock knock.");	
			}
			else if((VictorMain.findKeyword(jokeResponse, "there", 0)>= 0)){
				if(jokeResponse.equals("there")){
					VictorMain.print(jokeChoice);
				}
				else if(!jokeResponse.equals("there")){
					count++;
					variousResponses();
				}
			}
			else if((VictorMain.findKeyword(jokeResponse, "Amos", 0) >= 0)||(VictorMain.findKeyword(jokeResponse, "Etch", 0) >= 0)||(VictorMain.findKeyword(jokeResponse, "Cows go", 0) >= 0)){
				if(jokeResponse.equals(jokeChoice)){
					VictorMain.print(jokeAnswers[jokeIndex]);
					inJokeLoop= false;
					VictorMain.promptForever();
				}
				else if(!jokeResponse.equals(jokeChoice)){
					count++;
					variousResponses();
				}
			}
			
		}	
	}
	
	
	public static String getJoke(){
		int joke = (int) (Math.random()*jokes.length); 
		return jokes[joke];
	}
	
	public static void findIndexOfJoke(String joke){
		for(int i = 0; i < jokes.length; i++){
			if(jokes[i].equals(joke)){
				jokeIndex = i;
			}
		}
	}
	
	 public void variousResponses(){
		  int responseChoice = 0;
		  if(count > 3){
		   responseChoice = (int) (Math.random()*aggravated.length);
		   VictorMain.print(aggravated[responseChoice]);
		  }
		  else{
		   responseChoice = (int) (Math.random()*calm.length);
		   VictorMain.print(calm[responseChoice]);
		  }
	 }
}

	


