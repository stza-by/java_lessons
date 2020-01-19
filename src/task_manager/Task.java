package task_manager;

public class Task {

    private int id;
    private String content;
    private boolean done;

    public Task(int id, String content, boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public Task(int id, String content) {
        this(id, content, false);
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public boolean getDone() {
        return this.done;
    }

    public String setContent(String newContent) {
        this.content = newContent;
        return this.content;
    }

    public boolean setDone(boolean doneStatus) {
        this.done = doneStatus;
        return this.done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", done=" + done +
                '}';
    }
}
