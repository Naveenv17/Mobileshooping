import java.util.*;
class search {
    private String name;
    private int price;
	private int id;

    public search(int id,String name, int price) {
		this.id=id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
	public int getId(){
		return id;
	}

    public int getPrice() {
        return price;
    }
}
interface mobile
{
	public  void search();
	public void addToCart(int a);
	public void viewCart();
	public void generateBill(); 

}
class Mobileproduct implements mobile
{
int x=0;
	 Scanner sc=new Scanner(System.in);
		ArrayList<search> s=new ArrayList<>();
		ArrayList<search> b=new ArrayList<>();
		ArrayList<search> a=new ArrayList<>();
		ArrayList<search> h=new ArrayList<>();
       ArrayList<search> m=new ArrayList<>();
	    ArrayList<search> cart=new ArrayList<>();
	public  void search(){
		
   do
   {
	   System.out.println();
		System.out.println("Selelct Brand");
		System.out.println("1.Apple\n2.Realme\n3.Vivo\n4.Samsung\n5.Xiaomi");
		int n=sc.nextInt();
		switch(n){
			case 1:
				s.add(new search(1,"Apple Iphone 14", 60999));
		        s.add(new search(2,"Apple Iphone 13", 55999));
			    s.add(new search(3,"Apple Iphone 12", 45999));
				s.add(new search(4,"Apple Iphone 11", 40999));
				s.add(new search(5,"Apple Iphone XR", 38999));
				s.add(new search(6,"Apple Iphone 9 ",  35999));
				s.add(new search(7,"Apple Iphone S ",  28999));
			   System.out.println("ID      Products       Price");
				for (search prod : s) {
			System.out.println(prod.getId()+"   "+prod.getName()+"    "+prod.getPrice());
        }
			
			
			break;
			case 2:
				a.add(new search(8 ,  " Realme C53    "   ,     11999));
		        a.add(new search(9 ,  " Realme 10 Pro ",        24999));
			    a.add(new search(10,  "Realme 11 pro " ,       23999));
				a.add(new search(11,  "Realme C55    "    ,    10999));
				a.add(new search(12,  "Realme Narzo  "  ,      21999));
				
			   System.out.println("ID    Products             Price");
				for (search prod : a) {
			System.out.println(prod.getId()+"    "+prod.getName()+"       "+prod.getPrice());
        }
		break;
		 case 3:
			    b.add(new search(13,"Vivo Y100",     21999));
		        b.add(new search(14,"Vivo V27 ",     30999));
			    b.add(new search(15,"Vivo Y200",     21999));
				b.add(new search(16,"Vivo Y35 ",     16999));
				b.add(new search(17,"Vivo T2  ",     17999));
			   
			   System.out.println("ID   Products         Price");
				for (search prod : b) {
			System.out.println(prod.getId()+"   "+prod.getName()+"        "+prod.getPrice());
        }
		break;
		case 4:
			    h.add(new search(18,"Samsung Galaxy A14   ",    17999));
		        h.add(new search(19,"Samsung Galaxy S21 FE",    44999));
			    h.add(new search(20,"Samsung Galaxy F34   ",    21999));
				h.add(new search(21,"Samsung Galaxy F14   ",    16999));
				h.add(new search(22,"Samsung Galaxy A23   ",    23999));
			   
			   System.out.println("ID       Products             Price");
				for (search prod : h) {
			System.out.println(prod.getId()+"   "+prod.getName()+"    "+prod.getPrice());
			
        }
		break;
		case 5:
		        m.add(new search(23,"Redmi note 12 pro ",    27999));
		        m.add(new search(24,"Redmi 12C         ",    6799));
				m.add(new search(25,"Redmi 11 Prime    ",    10999));
				m.add(new search(26,"Redmi K50i 5G     ",    35999));
				m.add(new search(27,"Redmi Note 12+ Pro",    30999));

			   
			   System.out.println("ID     Products           Price");
				for (search prod : m) {
			System.out.println(prod.getId()+"   "+prod.getName()+"    "+prod.getPrice());
        }
        break;
		}
		do{
		System.out.println();
           System.out.println("1.I want add to cart\n2.Search in Other Brands");
	          x=sc.nextInt();
			  if (x>2)
			  {
				  System.out.println("Invalid choice");
			  }
		}while(x>2);
               
	 }while ( x==2);
	 System.out.println("Enter the mobile ID you want Add");
	          int mobileid=sc.nextInt();
               addToCart(mobileid);

     }	
	 
    
    public void addToCart(int mobileid) {
		 boolean found = false;
        for (ArrayList<search> productList : Arrays.asList(s, a, b, h, m)) {
            for (search prod : productList) {
                if (prod.getId() == mobileid) {
                    cart.add(prod);
                    System.out.println("Cart Added Sucessfull");
					System.out.println();
					found = true;
                break;
                    
                }
            }
        }
		if (!found)
		{
			        System.out.println("Invalid mobile ID. Please try again.");
		}

    }
	 public void viewCart() {
        System.out.println("Items in Cart:");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("ID    Products         Price");
            for (search prod : cart) {
                System.out.println(prod.getId()+ "   "+ prod.getName() + "    " + prod.getPrice());
				System.out.println();
            }
        }

}
    public void generateBill() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. No bill to generate.");
        } else {
            double totalBill = 0;
            System.out.println("ID     Products         Price");
            for (search prod : cart) {
                System.out.println(prod.getId() + "   " + prod.getName() + "    " + prod.getPrice());
                totalBill += prod.getPrice();
            }
			System.out.println("Total Cost="+totalBill);
			System.out.println("GST=18%");
			double cost=totalBill+totalBill*0.18f;
            System.out.println("Total Bill: " + cost);
            System.out.println("Bill generated successfully.");
			System.out.println();
        }
    }
}



class MobileDao {
    mobile instanceDoa() {
        return new Mobileproduct();
    }
}

class Mobileshop 
{
	public static void main(String[] args) {
		MobileDao h=new MobileDao();
		mobile m=h.instanceDoa();
		while (true)
		{
		System.out.println("Selelct Choice\n1.Search For Mobile\n2.View Cart\n3.Generate Bill\n4.Exit");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		switch (a)
		{
		case 1:
         m.search();
		break;
		case 2:
			m.viewCart();
		break;
		case 3:
			m.generateBill();
		break;
		case 4:
			System.out.println("Exited.....Thank You");
		System.exit(0);
		}
	}
}
}
