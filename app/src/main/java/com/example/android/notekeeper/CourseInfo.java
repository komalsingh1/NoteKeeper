package com.example.android.notekeeper;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Jim.
 */

public final class CourseInfo {
    private final String mCourseId;
    private final String mTitle;
    private final List<com.example.android.notekeeper.ModuleInfo> mModules;

    public CourseInfo(String courseId, String title, List<com.example.android.notekeeper.ModuleInfo> modules) {
        mCourseId = courseId;
        mTitle = title;
        mModules = modules;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<com.example.android.notekeeper.ModuleInfo> getModules() {
        return mModules;
    }

    public boolean[] getModulesCompletionStatus() {
        boolean[] status = new boolean[mModules.size()];

        for(int i=0; i < mModules.size(); i++)
            status[i] = mModules.get(i).isComplete();

        return status;
    }

    public void setModulesCompletionStatus(boolean[] status) {
        for(int i=0; i < mModules.size(); i++)
            mModules.get(i).setComplete(status[i]);
    }

    public com.example.android.notekeeper.ModuleInfo getModule(String moduleId) {
        for(com.example.android.notekeeper.ModuleInfo moduleInfo: mModules) {
            if(moduleId.equals(moduleInfo.getModuleId()))
                return moduleInfo;
        }
        return null;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInfo that = (CourseInfo) o;

        return mCourseId.equals(that.mCourseId);

    }

    @Override
    public int hashCode() {
        return mCourseId.hashCode();
    }

}
