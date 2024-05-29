package KtraTX1;

import java.util.*;
import java.util.stream.Collectors;

public class ComputerManagerIMPL implements ComputerManager {
    //khai báo và khởi tạo danh sách chứa các đối tượng Computer
    public static ArrayList<Computer> list = new ArrayList<>();

    public ComputerManagerIMPL() {
    }

    public void generateList(int n) {
        this.list = new ArrayList<>(n); //list được khởi tạo với kt ban đầu là n, và sau đó các đối tượng Computer được tạo và thêm vào danh sách nà
        String[] t = {"Lenovo", "Dell", "Asus", "HP", "MSI", "MacBook"};
        String[] c = {"Gray", "Black", "White", "Pink", "Blue"};
        String[] m = {"Plastic", "Steel", "Glass", "Aluminium"};
        String[] s = {"Big", "Small", "Old", "Luxury", "Durable"};
        //sinh ngẫu nhiên
        int index;
        for (int i = 0; i < n; i++) {
            Computer computer = new Computer(); //tạo đối tượng computer
            computer.setProduct_id(i);// thiết lập id cho sản phẩm

            index = (int) (Math.random() * t.length);
            computer.setProduct_name(t[index]);

            index = (1000 + (int) (Math.random() * 10000));
            computer.setProduct_price(index);

            index = (int) (Math.random() * 100);
            computer.setProduct_total(index);

            index = (int) (Math.random() * c.length);
            computer.setColor(c[index]);

            index = (int) (Math.random() * m.length);
            computer.setMaterial(m[index]);

            index = (int) (Math.random() * s.length);
            computer.setStyle(s[index]);

            this.list.add(computer);
        }
    }

    @Override
    public boolean addComputer(Computer c) {
        boolean flag = false;
        System.out.println("Input new computer: ");
        c.Input();
        for (Computer computer : list) {
            if (computer.getProduct_id() == c.getProduct_id()) {
                flag = true;
                System.out.println("ID is existed");
                break;
            }
        }
        if (!flag) { //true  kh có trùng id
            list.add(c);
        }
        return (list.contains(c)) ;//trả về true nếu thêm thành công và ngc lai;
    }

    @Override
    public boolean editComputer(Computer c) {
        int index = list.indexOf(c); //lay ra vị trí của c
        System.out.println("Input edit computer");
        c.Input();
        list.set(index, c); // Cập nhật đối tượng trong danh sách tại vị trí index
        return (list.get(index).equals(c)); //ss 2 dth tai vi tri index va c, neu = trả ve true va ngc lai

    }

    //ham xoa
    @Override
    public boolean delComputer(Computer c) {
        list.remove(c);
        return (list.contains(c));
    }

    //ham tim kiem
    @Override
    public List<Computer> searchComputers(String name) {
        ArrayList<Computer> results = new ArrayList<Computer>();
        Scanner sn = new Scanner(System.in);
        switch (name) {
            case "1":
                System.out.println("Enter name: ");
                String find_name = sn.nextLine();
                //Hàm này lọc các đối tượng từ một danh sách
                // (list) của các máy tính (Computer), giữ lại
                // chỉ những đối tượng có tên sản phẩm (product_name)
                // bằng với giá trị được chỉ định (find_name),
                // và trả về một danh sách mới chứa các đối tượng đã lọc đó.
                results = (ArrayList<Computer>) list.stream().filter(x -> x.getProduct_name().equals(find_name)).collect(Collectors.toList());
                break;
            case "2":
                System.out.println("Enter price: ");
                double find_price = sn.nextDouble();
                results = (ArrayList<Computer>) list.stream().filter(x -> x.getProduct_price() == find_price).collect(Collectors.toList());
                break;
            case "3":
                System.out.println("Enter total: ");
                int find_total = sn.nextInt();
                results = (ArrayList<Computer>) list.stream().filter(x -> x.getProduct_total() == find_total).collect(Collectors.toList());
                break;
            case "4":
                System.out.println("Enter color: ");
                String find_color = sn.nextLine();
                results = (ArrayList<Computer>) list.stream().filter(x -> x.getColor().equals(find_color)).collect(Collectors.toList());
                break;
            case "5":
                System.out.println("Enter Material: ");
                String find_material = sn.nextLine();
                results = (ArrayList<Computer>) list.stream().filter(x -> x.getMaterial().equals(find_material)).collect(Collectors.toList());
                break;
            case "6":
                System.out.println("Enter style: ");
                String find_style = sn.nextLine();
                results = (ArrayList<Computer>) list.stream().filter(x -> x.getStyle().equals(find_style)).collect(Collectors.toList());
                break;
            default:
                System.out.println("Invalid choice");
        }

        return results;
    }

    @Override
    public List<Computer> sortedComputer(double price) {
        List<Computer> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparing(Computer::getProduct_price)); //sap xep tang dan
        if (price == 0) {
            Collections.reverse(sortedList);
        }
        return sortedList;
    }

    public void printList() {
        this.list.forEach(computer -> {
            System.out.println(computer);
        });
        System.out.println();
    }

}
