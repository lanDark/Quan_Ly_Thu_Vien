/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.UserDAO;
import com.model.Cart;
import com.model.CtPhieumuon;
import com.model.NguoiDung;
import com.model.PhieuMuon;
import com.securityImpl.CustomUser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vital
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;
    private final Logger LOG=Logger.getLogger(UserDAOImpl.class.getName());
    
    @Override
    public NguoiDung login(String email) {
        try
        {
        LOG.info("Connect to method UserDAOIMPL.login :  "+email);
        Session session=sessionFactory.getCurrentSession();
        String hql="From NguoiDung ND where ND.email= :ND_email";
        Query query=session.createQuery(hql);
        query.setParameter("ND_email", email);
        NguoiDung nguoiDung = (NguoiDung) query.list().get(0);
        return nguoiDung;
        }catch(Exception e){
              Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, e);
              return null;
        }
    }

    @Override
    public boolean signIn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public boolean datMuon(ArrayList<Cart> listCart,CustomUser user) throws Exception {
        Session session=sessionFactory.getCurrentSession();
        PhieuMuon phieuMuon =this.createPhieuMuon( session.get(NguoiDung.class, user.getMaNguoiDung()));
        session.save(phieuMuon);
        LOG.info("Connect to method UserDAOIMPL.datMuon :  "+ user.getUsername());
            if(phieuMuon != null)
            {
                for(Cart item:listCart){ 
                    for(int  i = 1;i<=item.getSoLuong();i++){
                          try {
                            CtPhieumuon ctpm=new CtPhieumuon();
                            ctpm.setSach(item.getSach());
                            ctpm.setPhieuMuon(phieuMuon);
                            ctpm.setSoLuong(item.getSoLuong());
                            Query giamSoLuongSach=session.createQuery("update Sach set soLuong=soLuong-:soLuong where maSach=:maSach");
                            giamSoLuongSach.setParameter("maSach", item.getSach().getMaSach());
                            giamSoLuongSach.setParameter("soLuong", item.getSoLuong());
                            giamSoLuongSach.executeUpdate();
                            session.save(ctpm);
                        } catch (Exception ex) {
                            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                            throw new Exception("Xin lỗi sách: \""+ item.getSach().getTenSach()+"\" tạm thời đã hết!");
                        }
                    }
                }
                return true;
            }
        return false;
       
    }
    public PhieuMuon createPhieuMuon(NguoiDung nguoiDung) {
        PhieuMuon phieuMuon = new PhieuMuon();
          LOG.info("Connect to method UserDAOIMPL.createPhieuMuon :  "+ nguoiDung.getMaNguoiDung());
        Calendar c = Calendar.getInstance();
        try {
            phieuMuon.setTrangThai(1);
            phieuMuon.setNgayDat(c.getTime());
            phieuMuon.setNguoiDungByMaNguoiDung(nguoiDung);
            c.add(Calendar.DAY_OF_MONTH, 30);
            phieuMuon.setNgayPhaiTra(c.getTime());
            return phieuMuon;
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    }
}
