public class CircularBuffer {

    private int capacity;
    private String[] data;
    private int readIndex;
    private int writeIndex;

    public void create(){
        create(10);
    }

    public void create(int capacity){
        this.capacity = capacity;
        this.data = new String[capacity];
        this.readIndex = 0;
        this.writeIndex = -1;
    }

    public void write(String input) throws Exception {
        //TODO
    }

    public String read() throws Exception {
        //TODO
    }

    public boolean isFull(){
        //TODO
    }

    public boolean isEmpty(){
        //TODO
    }

    public int getSize(){
        return this.capacity;
    }
}
