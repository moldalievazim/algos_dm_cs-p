class BrowserHistory {
    public class Node {
      String url;
      Node prev;
      Node next;

      public Node (String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
      }
    }

    private Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newUrl = new Node(url);
        curr.next = newUrl;
        newUrl.prev = curr;
        curr = newUrl;
    }
    
    public String back(int steps) {
        for (; curr.prev != null && steps > 0; steps--) {
          curr = curr.prev;
        }

        return curr.url;
    }
    
    public String forward(int steps) {
        for (; curr.next != null && steps >0; steps--) {
          curr = curr.next;
        }

        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */