import java.util.Scanner;
public class Main {
    public static String[] todos = new String[10];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        addTodoList("Membaca");
        addTodoList("Makan");
        addTodoList("Menggambar");
        showTableTodo();
        removeTodoList(2);
        System.out.println("After remove");
        showTableTodo();
    }
    public static void showTableTodo() {
        System.out.println("Todo List");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if(todos[i] != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }
    public static void addTodoList (String todo) {
        boolean isFull = isArrayFull();

        for (int i = 0; i < todos.length; i++){
            if(todos[i] == null){
                todos[i] = todo;
                break;
            }
        }
    }
    public static void resizeArrayIfFull() {
        boolean isFull = isArrayFull();
    }
    private static void resizeArrayToTwoTimesBigger() {
            String[] temp = todos;
            todos = new String[todos.length * 2];
            for(int i = 0; i < temp.length; i++){
                todos[i] = temp[i];
            }
        }
    private static boolean isArrayFull() {
        boolean isFull = true;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    public static boolean removeTodoList ( Integer number){
        if (isSelectorTodoNotValid(number)) return false;
        for (int i = number-1; i < todos.length;i++){
            if(i == (todos.length -1)){
                todos[i] = null;
            }else {
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }

    private static boolean isSelectorTodoNotValid(final Integer number) {
        if (number <= 0) {
            return true;
        }
        if (todos[number - 1] == null){
            return true;
        }
        if (number - 1 > todos.length-1) {
            return true;
        }
        return false;
    }
    public static boolean editTodoList(Integer number, String newTodo){
        if(isSelectorTodoNotValid(number)){
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }
    public static void showmainMenu(){
        boolean isRunning = true;
        while(isRunning){
            showTableTodo();
            System.out.println("Menu");
            System.out.println("Tambah");
            System.out.println("Hapus");
            System.out.println("edit");
            System.out.println("Keluar");
            String selectedMenu = input("Pilih");
            Switch (selectedMenu) {
                case "1" :
                    showMenuAddTodoList();
                    System.out.print("Menu add todo list");
                    break;
                case "2":
                    showMenuRemoveTodoList();
                    System.out.print("Menu remove todo list");
                    break;
                case "3":
                    showMenuRemoveTodoList();
                    System.out.print("Menu Edit todo list");
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }
    public static String input(String info) {
        System.out.println(info = " :");
        String data = scanner.nextLine();
        return data;
    }
    public static void showMenuAddTodoList(){
        System.out.print("Menambah todo list");
        String todo = input("Todo (x jika batal)");
        if(todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void showMenuRemoveTodoList(){
        System.out.println("Menghapus todo list");
        String todoYangDipilih = input("Nomer todo yang di hapus (x jia batal)");
        if(todoYangDipilih.equals("x")){
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(todoYangDipilih));
            if(!success){
                System.out.println("Gagal mengpus todo list");
            }
        }
    }
    public static void showMenuEditTodoList(){
        System.out.print("Menedit toso list");
        String selectedTodo = input("Masukan nomer todo (x jika batal");
        if(selectedTodo.equals("x")){
            return;
        }
        String newTodo = input("Masukan todo yang baru(x jika batal");
        if(newTodo.equals("x")){
            return;
        }
        boolean isEdiTodoSuccess = editTodoList(Integer.valueOf(selectedTodo), newTodo);
        if(isEdiTodoSuccess){
            System.out.println("Berhasil mengedit Todo");
        } else{
            System.out.println("Gagal mengedit Todo");
        }
    }
}