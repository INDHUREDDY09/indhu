import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int curr;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
    }
    
    public void visit(String url) {
        // Move to the next slot
        curr++;
        
        // If curr is within existing bounds, overwrite; otherwise append
        if (curr < history.size()) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        
        // Clear all forward history virtually by truncating the sublist
        history = history.subList(0, curr + 1);
    }
    
    public String back(int steps) {
        // Prevent moving past the homepage (index 0)
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        // Prevent moving past the latest visited page
        curr = Math.min(history.size() - 1, curr + steps);
        return history.get(curr);
    }
}