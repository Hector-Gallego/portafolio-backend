package com.portafolio.backend.portafolio_backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(columnDefinition = "TEXT")
    private String about;
    @Column(columnDefinition = "TEXT")
    private String challenges;
    @Column(columnDefinition = "TEXT")
    private String overview;

    @Column(columnDefinition = "TEXT")
    private String imgUrls;

    @Column(columnDefinition = "TEXT")
    private String urlRepoBackend;

    @Column(columnDefinition = "TEXT")
    private String urlRepoFrontend;

    @Column(columnDefinition = "TEXT")
    private String urlDemo;

    


    @ManyToMany
    @JoinTable(name = "projects_as_categories",
    joinColumns = @JoinColumn(name="project_id"),
    inverseJoinColumns = @JoinColumn(name="category_id"))
    private List<Category> categories = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "projects_as_role_projects",
    joinColumns = @JoinColumn(name="project_id"),
    inverseJoinColumns = @JoinColumn(name = "role_project_id"))
    private List<RoleProject> roleProjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "projects_as_technologies",
    joinColumns = @JoinColumn(name="project_id"),
    inverseJoinColumns = @JoinColumn(name="technology_id"))
    private List<Technology> technologies = new ArrayList<>();

 

    public Project() {
    }



    public Project(Long id, String name, Date date, String about, String challenges, String overview, String imgUrls,
            String repo_backend_url, String repo_frontend_url, String repo_demo_url, List<Category> categories,
            List<RoleProject> roleProjects, List<Technology> technologies) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.about = about;
        this.challenges = challenges;
        this.overview = overview;
        this.imgUrls = imgUrls;
        this.urlRepoBackend = repo_backend_url;
        this.urlRepoFrontend = repo_frontend_url;
        this.urlDemo = repo_demo_url;
        this.categories = categories;
        this.roleProjects = roleProjects;
        this.technologies = technologies;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public Date getDate() {
        return date;
    }



    public void setDate(Date date) {
        this.date = date;
    }



    public String getAbout() {
        return about;
    }



    public void setAbout(String about) {
        this.about = about;
    }



    public String getChallenges() {
        return challenges;
    }



    public void setChallenges(String challenges) {
        this.challenges = challenges;
    }



    public String getOverview() {
        return overview;
    }



    public void setOverview(String overview) {
        this.overview = overview;
    }



    public String getImgUrls() {
        return imgUrls;
    }



    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }



    public String getUrlRepoBackend() {
        return urlRepoBackend;
    }



    public void setUrlRepoBackend(String repo_backend_url) {
        this.urlRepoBackend = repo_backend_url;
    }



    public String getUrlRepoFrontend() {
        return urlRepoFrontend;
    }



    public void setUrlRepoFrontend(String repo_frontend_url) {
        this.urlRepoFrontend = repo_frontend_url;
    }



    public String getUrlDemo() {
        return urlDemo;
    }



    public void setUrlDemo(String repo_demo_url) {
        this.urlDemo = repo_demo_url;
    }



    public List<Category> getCategories() {
        return categories;
    }



    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }



    public List<RoleProject> getRoleProjects() {
        return roleProjects;
    }



    public void setRoleProjects(List<RoleProject> roleProjects) {
        this.roleProjects = roleProjects;
    }



    public List<Technology> getTechnologies() {
        return technologies;
    }



    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    

   
   
    

   
}
