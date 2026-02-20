package com.klu.service;

import com.klu.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Course getCourseById(int id) {
        for (Course course : courseList) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    public Course updateCourse(int id, Course updatedCourse) {
        for (Course course : courseList) {
            if (course.getCourseId() == id) {
                course.setTitle(updatedCourse.getTitle());
                course.setDuration(updatedCourse.getDuration());
                course.setFee(updatedCourse.getFee());
                return course;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courseList.removeIf(course -> course.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                result.add(course);
            }
        }
        return result;
    }
}