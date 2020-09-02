
public class AsciiArtTest {

  public static void main(String[] args) {
    System.out.println(testStackPushPeek());
  }

  public static boolean testStackPushPeek() {
    DrawingChange change1 = new DrawingChange(1, 1, 'a', 'b');
    DrawingChange change2 = new DrawingChange(1, 2, 'c', 'd');

    DrawingStack stack = new DrawingStack();
    if (stack.peek() == null) {
      stack.push(change1);
      if (stack.peek() == change1) {
        stack.push(change2);
        if (stack.peek() == change2) {

          if (stack.pop() == change2 && stack.peek() == change1) {

            stack.push(change2);
            for (Object value : stack) {
              System.out.println(value.toString());
            }
            return true;
          }
        }
      }
    }

    return false;
  }


}
