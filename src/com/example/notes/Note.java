package com.example.notes;

import org.joda.time.DateTime;

/**
 * A simple data object representing a single note with validation.
 */
public class Note {
    private long id;
    private String title;
    private String content;
    private DateTime createdAt; // Uses Legacy Joda-Time

    // Default constructor
    public Note() {}

    public Note(String title, String content) {
        // Validation is now delegated to setters to be consistent
        this.setTitle(title);
        this.setContent(content);
        this.setCreatedAt(new DateTime()); // Defaults to now
    }

    // Getters and Setters with Validation
    public long getId() {
        return id;
    }

    public void setId(long id) {
        // ADDED VALIDATION: ID cannot be negative.
        if (id < 0) {
            throw new IllegalArgumentException("Note ID cannot be negative.");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // ADDED VALIDATION: Title must not be null or just whitespace.
        if (title == null || title.trim().equals("")) {
             throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        // ADDED VALIDATION: Title has a maximum length.
        if (title.length() > 100) {
            throw new IllegalArgumentException("Title cannot exceed 100 characters.");
        }
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        // ADDED VALIDATION: Content cannot be null.
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null.");
        }
        this.content = content;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        // ADDED VALIDATION: Creation date cannot be null.
        if (createdAt == null) {
            throw new IllegalArgumentException("CreatedAt timestamp cannot be null.");
        }
        this.createdAt = createdAt;
    }

    public String toString() {
        return "Note[id=" + id + ", title=" + title + ", created=" + createdAt + "]";
    }
}
