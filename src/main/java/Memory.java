class Memory {

  int[] memory;
  private int memoryPointer;

  Memory(int size) {
    memory = new int[size];
    memoryPointer = 0;
  }

  Memory(int[] memory) {
    this.memory = memory;
  }

  public int currentDataValue() {
    return memory[memoryPointer];
  }

  public void setCurrentDataValue(int value) {
    memory[memoryPointer] = value;
  }

  public void decPointer() {
    memoryPointer--;
  }

  public void decValue() {
    memory[memoryPointer]--;
  }

  public void incPointer() {
    memoryPointer++;
  }

  public void incValue() {
    memory[memoryPointer]++;
  }
}
