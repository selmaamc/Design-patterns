
public class Test {
	

	    public static void main(String args[]) throws InterruptedException {
	        
	        // we can provide any strategy to do the sorting 
	        Produit p1= new Produit("produit1",50,1);
	        Produit p2= new Produit("produit2",87,4);
	        Produit p3= new Produit("produit3",96,2);
	        Produit[] array = {p1,p2,p3};
	        Context ctx = new Context(new BubbleSort());
	        ctx.arrange(array);
	        
	        // we can change the strategy without changing Context class
	        ctx = new Context(new InsertionSort());
	        ctx.arrange(array);
		
		// try it yourself then …
	    }
	}

	interface Strategy {
	    public void sort1(Produit[] products);
	}

	class BubbleSort implements Strategy {
	        static void printArray(Produit arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i].nom +" "); 
	        System.out.println(); 
	    }
	      public void sort(Produit[] products) {  
	        int n = products.length;  
	        Produit temp = new Produit("0",0,0);  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(products[j-1].prix > products[j].prix){  
	                                 //swap elements  
	                                 temp = products[j-1];  
	                                 products[j-1] = products[j];  
	                                 products[j] = temp;  
	                         }  
	                 }  
	         }
	         System.out.println("sorting array using Bubble sort strategy : ");
	         printArray(products); 
	       }
		public void sort1(Produit[] products) {
			// TODO Auto-generated method stub
			
		}
	}

	class InsertionSort implements Strategy {
	    
	       static void printArray(Produit arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i].nom+" "); 
	        System.out.println(); 
	    }

	    public void sort1(Produit[] products) {
	        int n = products.length;  
	        for (int j = 1; j < n; j++) {  
	            Produit key = products[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( products [i].prix > key.prix ) ) {  
	                products [i+1] = products [i];  
	                i--;  
	            }  
	            products[i+1] = key;  
	        }  
	        System.out.println("sorting array using insertion sort strategy");
	        printArray(products);
	    }

		public void sort(Produit[] products) {
			// TODO Auto-generated method stub
			
		}
	}

	class QuickSort implements Strategy {
	    
	        static void printArray(Produit arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i].nom+" "); 
	        System.out.println(); 
	    }
	    
	    
	       int partition(Produit[] products, int low, int high) 
	    { 
	        Produit pivot = products[high];  
	        int i = (low-1); // index of smaller element 
	        for (int j=low; j<high; j++) 
	        { 
	            // If current element is smaller than the pivot 
	            if (products[j].prix < pivot.prix) 
	            { 
	                i++; 
	  
	                // swap arr[i].nom and arr[j] 
	                Produit temp = products[i]; 
	                products[i] = products[j]; 
	                products[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        Produit temp = products[i+1]; 
	        products[i+1] = products[high]; 
	        products[high] = temp; 
	  
	        return i+1; 
	    } 
	  
	  
	        void sort2(Produit[] products, int low, int high)
	        {
	            if (low < high) 
	            { 
	                /* pi is partitioning index, arr[pi] is  
	                  now at right place */
	                int pi = partition(products, low, high); 
	      
	                // Recursively sort elements before 
	                // partition and after partition 
	                sort2(products, low, pi-1); 
	                sort2(products, pi+1, high); 
	            }
	        }
	    /* The main function that implements QuickSort() 
	      arr[] --> Array to be sorted, 
	      low  --> Starting index, 
	      high  --> Ending index */
	    public void sort(Produit[] products) 
	    { 
	       int low = 0;
	       int high = products.length-1;
	       sort2(products,low,high);
	       System.out.println("sorting array using quick sort strategy");
	       printArray(products);
	    }


		public void sort1(Produit[] products) {
			// TODO Auto-generated method stub
			
		} 
	}

	class MergeSort implements Strategy {

	    //@Override
	        static void printArray(Produit arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i].nom+" "); 
	        System.out.println(); 
	    }
	   void merge(Produit[] products, int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        /* Create temp arrays */
	        Produit L[] = new Produit[n1];
	        Produit R[] = new Produit[n2];
	 
	        
	        for (int i = 0; i < n1; ++i)
	            L[i] = products[l + i];
	        for (int j = 0; j < n2; ++j)
	            R[j] = products[m + 1 + j];
	 
	        /* Merge the temp arrays */
	 
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2) {
	            if (L[i].prix <= R[j].prix) {
	                products[k] = L[i];
	                i++;
	            }
	            else {
	                products[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) {
	            products[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) {
	            products[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	    // Main function that sorts arr[l..r] using
	    // merge()
	     void sort2(Produit[] products, int l, int r){
	        if (l < r) {
	            // Find the middle point
	            int m = (l + r) / 2;
	 
	            // Sort first and second halves
	            sort2(products, l, m);
	            sort2(products, m + 1, r);
	 
	            // Merge the sorted halves
	            merge(products, l, m, r);
	        }
	    }
	    public void sort(Produit[] products){
	        int l = 0;
	        int r = products.length-1;
	        sort2(products, l , r);
	        
	         System.out.println("sorting array using merge sort strategy : ");
	         printArray(products); 
	        }
		public void sort1(Produit[] products) {
			// TODO Auto-generated method stub
			
		}
	        
	    
	 
	}
	class Produit {
	    String nom;
	    float prix;
	    int valeur;
	    public Produit(String nom, float prix, int valeur){
	        this.nom=nom;
	        this.prix=prix;
	        this.valeur=valeur;
	    }
	}
	class Context {
	    private final Strategy strategy;

	    public Context(Strategy strategy) {
	        this.strategy = strategy;
	    }

	    public void arrange(Produit[] array) {
	        strategy.sort1(array);
	    }
	

}
