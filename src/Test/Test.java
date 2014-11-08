package Test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cmdString = "image( head.jpg )";
		int startIndex = cmdString.indexOf('(');
		int endIndex = cmdString.indexOf(")");
		
		int index = cmdString.indexOf(",");
		System.out.println(index);
		
		//cmdString = cmdString.substring(startIndex+1, endIndex).trim();
		//System.out.println(cmdString);
		if (cmdString.startsWith("image")) {
			System.out.println("yes");
		}

	}

}
