/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Interface.CRUD;
import com.model.NguoiDung;
/**
 *
 * @author vital
 */
public interface UserDAO extends CRUD<NguoiDung,String>{

    /**
     * Xử lý chức năng lấy người dùng
     * @param email
     * @return NguoiDung
     */
    public NguoiDung getUserByEmail(String email);

    /**
     *
     * @param nguoiDung đối tượng người dùng
     * @see NguoiDung
     * @return true nếu đăng ký thành công - false nếu có lỗi hoặc đăng ký thất bại
     */
    public boolean signUp(NguoiDung nguoiDung);
}
