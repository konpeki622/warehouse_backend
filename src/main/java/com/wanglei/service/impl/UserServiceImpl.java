package com.wanglei.service.impl;

import com.wanglei.mapper.LoginMapper;
import com.wanglei.mapper.UserMapper;
import com.wanglei.pojo.User;
import com.wanglei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletOutputStream;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<User> getUser(Integer auth, String[] keywords, Integer page) {
        return userMapper.getUser(auth, keywords, page, null);
    }

    @Override
    public Integer getUserCount(Integer auth, String[] keywords) {
        return userMapper.getUserCount(auth, keywords);
    }

    @Override
    public boolean register(String username, String password, Integer auth, String workid, String nickname, String gender, String phone, String email) {
        if (username.isEmpty() || password.isEmpty()) return false;
        userMapper.insertUser(username, password, auth, workid, nickname, gender, email, phone);
        return true;
    }

    @Override
    public Integer updateUser(Integer id, String oldPassword, String newPassword, String phone, String email, Integer auth, String nickname) {
        if (!userMapper.findById(id).getPassword().equals(oldPassword)) return 404;
        else {
            userMapper.updateUser(id, newPassword, auth, nickname, phone, email);
            return 200;
        }
    }

    @Override
    public boolean deleteUser(Integer id) {
        userMapper.deleteUser(id);
        return true;
    }

//    @Override
//    public void export(Integer auth, String[] keywords, Integer pageStart, Integer pageEnd, ServletOutputStream out) throws Exception{
//        try{
//            // 第一步，创建一个workbook，对应一个Excel文件
//            HSSFWorkbook workbook = new HSSFWorkbook();
//
//            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
//            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
//
//            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
//
//            HSSFRow row = hssfSheet.createRow(0);
//            // 第四步，创建单元格，并设置值表头 设置表头居中
//            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
//
//            //居中样式
//            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//            HSSFCell hssfCell = null;
//            String[] titles = {"工号", "用户名", "姓名", "性别", "电话", "邮箱"};
//
//            for (int i = 0; i < titles.length; i++) {
//                hssfCell = row.createCell(i);//列索引从0开始
//                hssfCell.setCellValue(titles[i]);//列名1
//                hssfCell.setCellStyle(hssfCellStyle);//列居中显示
//            }
//
//            //这里我把list当做数据库啦
//            List<User> list = userMapper.getUser(auth, keywords, pageStart, pageEnd);
//            for (int i = 0; i < list.size(); i++) {
//                row = hssfSheet.createRow(i+1);
//                User user = list.get(i);
//
//                // 第六步，创建单元格，并设置值
//                String  workid = "";
//                if(user.getWorkId() != null){
//                    workid = user.getWorkId();
//                }
//                row.createCell(0).setCellValue(workid);
//                String username = "";
//                if(user.getUsername() != null){
//                    username = user.getUsername();
//                }
//                row.createCell(1).setCellValue(username);
//                String nickname = "";
//                if(user.getNickname() != null){
//                    nickname = user.getNickname();
//                }
//                row.createCell(2).setCellValue(nickname);
//                String gender = "";
//                if(user.getGender() !=null){
//                   gender = user.getGender();
//                }
//                row.createCell(3).setCellValue(gender);
//                String phone= "";
//                if(user.getPhone() !=null){
//                    phone = user.getPhone();
//                }
//                row.createCell(4).setCellValue(phone);
//                String email = "";
//                if(user.getEmail() !=null){
//                    email = user.getEmail();
//                }
//                row.createCell(5).setCellValue(email);
//            }
//
//            // 第七步，将文件输出到客户端浏览器
//            try {
//                workbook.write(out);
//                out.flush();
//                out.close();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new Exception("导出信息失败！");
//
//        }
//    }
}
