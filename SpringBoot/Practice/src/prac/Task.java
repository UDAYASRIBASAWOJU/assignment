package prac;

public class Task {

    private final long id;      // Required
    private final String summary; // Optional

    // Private constructor
    private Task(Builder builder) {
        this.id = builder.id;
        this.summary = builder.summary;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    // Builder Class
    public static class Builder {

        private final long id;       // Required
        private String summary = ""; // Optional default value

        public Builder(long id) {
            this.id = id;
        }

        public Builder summary(String s) {
            this.summary = s;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
    
    public static void main(String[] args) {
    	Task t = new Task.Builder(1)
                .summary("Complete Spring Boot project")
                .build();
    	
    	 System.out.println("Task ID: " + t.getId());
    	 System.out.println("Task Summary: " + t.getSummary());
	}
}