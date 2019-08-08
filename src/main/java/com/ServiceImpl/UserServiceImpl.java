/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ServiceImpl;

import com.DAO.UserDAO;
import com.Service.UserService;
import com.model.Cart;
import com.model.NguoiDung;
import com.model.Sach;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vital
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAOImpl;
    
    @Override
    public boolean login(HttpServletRequest rq,String email,String password) {
        NguoiDung nguoiDung= userDAOImpl.login(email);
        if(nguoiDung != null){
            System.out.println("Nguoi Dung: "+ nguoiDung.getHoTen());
            if(nguoiDung.getEmail().equals(email) && nguoiDung.getMatKhau().equals(password))
            {
                rq.getSession().setAttribute("nguoiDung", nguoiDung);
                return true;
            }
        }
        else{
            return false;
        }
        return false;
    }

    @Override
    public boolean signIn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean logOut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean datMuon(HttpServletRequest req) throws Exception {
        ArrayList<Cart> cartItems = (ArrayList<Cart>) req.getSession().getAttribute("cartItems");
        NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute("nguoiDung");
        if(nguoiDung != null && nguoiDung.getRules().getId() == 2){
            if(cartItems.size()>0)
            {
                if( userDAOImpl.datMuon(cartItems,nguoiDung) ){
                    req.getSession().removeAttribute("cartItems");
                    return true;
                }
            }
        }
        return false;
    }
}