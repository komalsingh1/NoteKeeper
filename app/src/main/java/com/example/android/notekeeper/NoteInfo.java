package com.example.android.notekeeper;
import android.os.Parcel;
import android.os.Parcelable;
public final class NoteInfo {
    private com.example.android.notekeeper.CourseInfo mCourse;
    private String mTitle;
    private String mText;

    public NoteInfo(com.example.android.notekeeper.CourseInfo course, String title, String text) {
        mCourse = course;
        mTitle = title;
        mText = text;
    }

    public com.example.android.notekeeper.CourseInfo getCourse() {
        return mCourse;
    }

    public void setCourse(com.example.android.notekeeper.CourseInfo course) {
        mCourse = course;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    private String getCompareKey() {
        return mCourse.getCourseId() + "|" + mTitle + "|" + mText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteInfo that = (NoteInfo) o;

        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

}
