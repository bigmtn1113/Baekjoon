import java.util.Scanner;

public class Main {
	public static int[] usedIngredients;
	public static int usedIngredientsArrayIndex = 0;
	
	public static int answer = 1000000000;
	
	public static void recursionFunc(int[][] ingredients, int ingredientCnt, int preIngredient, int cnt) {
		if (cnt == ingredientCnt) {
			int totalS = ingredients[usedIngredients[0]][0];
			int totalB = ingredients[usedIngredients[0]][1];
			
			for (int i = 1; i < usedIngredientsArrayIndex; ++i) {
				totalS *= ingredients[usedIngredients[i]][0];
				totalB += ingredients[usedIngredients[i]][1];
			}
			
			answer = Math.min(answer, Math.abs(totalS - totalB));
			return;
		}
		
		for (int i = preIngredient + 1; i < ingredients.length; ++i) {
			usedIngredients[usedIngredientsArrayIndex++] = i;
			
			recursionFunc(ingredients, ingredientCnt, i, cnt + 1);
			
			--usedIngredientsArrayIndex;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] ingredients = new int[n][2];
		
		for (int i = 0; i < n; ++i) {
			ingredients[i][0] = sc.nextInt();
			ingredients[i][1] = sc.nextInt();
		}
		
		sc.close();
		
		usedIngredients = new int[n];
		
		for (int ingredientCnt = 1; ingredientCnt <= n; ++ingredientCnt) {
			recursionFunc(ingredients, ingredientCnt, -1, 0);
		}
		
		System.out.print(answer);
	}

}
