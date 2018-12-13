import java.util.Random;

public class TCTreeTEST 
{
	public static void Run()
	{
		//TestsFonctionTCTree();
		TestsPerformancesTCTree();
	}
	private static void TestsPerformancesTCTree()
	{
		TCTree tree = new TCTree();
		
		int insertionCount = 100000;
		
		long a = System.nanoTime();
		
		for (int i = 0;i < insertionCount;i++)
		{
			Random rand = new Random(); // on reinstancie le random, pour regénerer le seed.
			int  n = rand.nextInt(1000000) + 1; // 
			tree.associe(Integer.toString(n), "whatever");
		}
		
		long b = System.nanoTime();
		
		System.out.println("[TCTree]: La fonction associe() a pris "+(GetElapsedTime(a,b))+"ms pour "+insertionCount+" insertions");
		
     	a = System.nanoTime();
		
		for (int i = 0;i < insertionCount;i++)
		{
			Random rand = new Random(); // on reinstancie le random, pour regénerer le seed.
			int  n = rand.nextInt(1000000) + 1; // 
			tree.get(Integer.toString(n));
		}
		
		b = System.nanoTime();
		
		System.out.println("[TCTree]: La fonction get() a pris "+(GetElapsedTime(a,b))+"ms pour "+insertionCount+" valeurs");
	}
	
	private static void TestsFonctionTCTree()
	{
		TCTree tree = new TCTree();
		
		tree.associe("b", "vall");
	    
		   
		tree.associe("a", "val2");
		    
		    
		tree.associe("c", "val3");
		    
	 	tree.associe("d", "cece");
        String result =  tree.get("c"); 
        
        tree.supprimer("b"); // On peut tester les trois cas de la fonctions supprimer en testant avec b (root) avec d (leaf) et avec c (single child)
        
        System.out.println(result);
		
	}
	private static long GetElapsedTime(long aNano,long bNano) // en millisecondes
	{
		return (bNano-aNano)/1000000;
	}
}
