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
        if (!isFull()) {
            int nextWriteIndex = writeIndex + 1;
            data[nextWriteIndex % capacity] = input;
            writeIndex++;
        }
        throw new Exception("Buffer Overflow Exception");
    }

    public String read() throws Exception {
        if (!isEmpty()) {
            String nextValue = data[readIndex % capacity];
            readIndex++;
            return nextValue;
        }
        throw new Exception("Empty Buffer Exception");
    }

    public boolean isFull(){
        return (writeIndex - readIndex) + 1 == capacity;
    }

    public boolean isEmpty(){
        return writeIndex < readIndex;
    }

    public int getSize(){
        return this.capacity;
    }
}
