/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import entities.Job;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Dayinta Warih Wulandari
 */
public class JobController {

    private final JobDAO jdao;

    public JobController(Connection connection) {
        this.jdao = new JobDAO(connection);
    }

    /**
     * Fungsi untuk melakukan insert data dengan parameter jobId, jobTitle, minSalary, maxSalary dengan return value boolean
     * @param jobId job_Id yang ingin ditambahkan. String.
     * @param jobTitle job_Title yang ingin ditambahkan. String.
     * @param minSalary min_salary yang ingin ditambahkan. Int.
     * @param maxSalary max_salary yang ingin ditambahkan. Int.
     * @return memanggil method insert dari class JobDAO dengan parameter membuat instance dari kelas Job
     * dimana instance tersebut berisi jobId, jobTitle, minSalary, maxSalary
     */
    public boolean save(String jobId, String jobTitle, int minSalary, int maxSalary) {
        return this.jdao.insert(new Job(jobId, jobTitle, minSalary, maxSalary));
    }

    /**
     * Fungsi untuk melakukan insert data dengan parameter jobId, jobTitle, minSalary, maxSalary dengan return value boolean
     * @param job_Id yang ingin diubah. String.
     * @param jobTitle job_Title yang ingin diubah. String.
     * @param minSalary min_salary yang ingin diubah. Int.
     * @param maxSalary max_salary yang ingin diubah. Int.
     * @return memanggil method update dari class JobDAO dengan parameter membuat instance dari kelas Job
     * dimana instance tersebut berisi jobId, jobTitle, minSalary, maxSalary
     */
    public boolean edit(String jobId, String jobTitle, int minSalary, int maxSalary) {
        return this.jdao.update(new Job(jobId, jobTitle, minSalary, maxSalary));
    }

    /**
     * Fungsi untuk menghapus data dari Jobs
     * @param jobId id dari data yang ingin dihapus
     * @return memanggil Fungsi delete dari class JobDAO dengan parameter jobId
     */
    public boolean drop(String jobId) {
        return this.jdao.delete(jobId);
    }

    /**
     * Fungsi untuk menampilkan semua data
     * @return memanggil fungsi getAll dari class JobDAO
     */
    public List<Object[]> binding() {
        return this.jdao.getAll();
    }

    /**
     * Fungsi untuk menampilkan semua data dengan terurut
     * @param category order by category. String.
     * @param sort tipe sortir
     * @return memanggil fungsi getAll dari class JobDAO dengan parameter catogory dan sort
     */
    public List<Object[]> bindingSort(String category, String sort) {
        return this.jdao.getAllSort(category, sort);
    }

    /**
     * Fungsi untuk menampilkan data tertentu
     * @param category category pencarian data berdasarkan variabel ini. String.
     * @param data keyword pencarian. String.
     * @return memamnggil fungsi search dari class JobDAO dengan parameter category dan data
     */
    public List<Object[]> find(String category, String data) {
        return this.jdao.search(category, data);
    }

    public Object findById(String jobId) {
        return this.jdao.getById(jobId);
    }

}
