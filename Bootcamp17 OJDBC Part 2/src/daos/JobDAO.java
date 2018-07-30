/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import entities.Job;
import java.sql.Connection;
import java.util.List;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class JobDAO {

    private final FunctionDAO fdao;

    public JobDAO(Connection connection) {
        this.fdao = new FunctionDAO(connection);
    }

    /**
     * Fungsi untuk insert data
     * @param job instance dari class Job
     * @return memanggil fungsi executeDML dari class FunctionDAO dengan parameter query untuk insert
     */
    public boolean insert(Job job) {
        return this.fdao.executeDML("INSERT INTO Jobs VALUES( '"
                + job.getJobId() + "', '" + job.getJobTitle() + "',"
                + job.getMinSalary() + ", " + job.getMaxSalary() +")");
    }

    /**
     * Fungsi untuk update data
     * @param job instance dari class Job
     * @return memanggil fungsi executeDML dari class FunctionDAO dengan parameter query untuk update
     */
    public boolean update(Job job) {
        return this.fdao.executeDML("UPDATE Jobs SET job_title= '" + job.getJobTitle()
                + "', min_salary=" + job.getMinSalary() + ", max_salary=" + job.getMaxSalary()
                + " WHERE job_id='" + job.getJobId()+"'");
    }

    /**
     * Fungsi untuk menghapus data
     * @param jobId job_id dari data yang ingin di hapus
     * @return memanggil fungsi executeDML dari class FunctionDAO dengan parameter query hapus
     */
    public boolean delete(String jobId) {
        return this.fdao.executeDML("DELETE FROM Jobs WHERE job_id='" + jobId +"'");
    }

    /**
     * Fungsi untuk menampilkan semua data
     * @return  memanggil fungsi getAll dari class FunctionDAO dengan parameter query untuk menampilkan data
     */
    public List<Object[]> getAll() {
        return this.fdao.getAll("SELECT * FROM Jobs");
    }

    /**
     * Fungsi untuk menampilkan semua data dengan sorting
     * @param category data akan diurutkan berdasarkan variabel ini
     * @param sort jenis sortir
     * @return memanggil fungsi getAll dari class FunctionDAO dengan parameter query untuk menampilkan data
     */
    public List<Object[]> getAllSort(String category, String sort) {
        return this.fdao.getAll("SELECT * FROM Jobs ORDER BY " + category + " " + sort);
    }

    /**
     * Fungsi untuk menampilkan beberapa data / search
     * @param category data akan dicari dari kategori ini
     * @param data keyword pencarian
     * @return memanggil fungsi getAll dari class FunctionDAO dengan parameter query search
     */
    public List<Object[]> search(String category, String data) {
        return this.fdao.getAll("SELECT * FROM Jobs WHERE " + category + " LIKE '%" + data + "%'");
    }
    /**
     * Fungsi untuk menampilkan data dengan id tertentu
     * @param jobId id data yang akan ditampilkan
     * @return memanggil fungsi getDataByID dengan query
     */
    public Object getById(String jobId){
        return this.fdao.getDataByID("SELECT * FROM Jobs WHERE job_id='" + jobId +"'");
    }

}
