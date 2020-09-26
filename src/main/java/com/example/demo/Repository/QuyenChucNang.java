package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Login;
import com.example.demo.models.PhongBan;
import com.example.demo.models.QLUser;

@Repository
public interface QuyenChucNang extends CrudRepository<QLUser,Long>{
	@Query(value = "select qus.tendangnhap from qluser qus  inner join userchucnang ucn on qus.id=ucn.iduser inner join chucnang cn on cn.id=ucn.idcn inner join vaitro vt on vt.id=qus.idvaitro  inner join vaitrochucnang vtc on vtc.idvt=vt.id   inner join groupuser gu on gu.id=qus.idgroupuser inner join groupusercn gucn on gucn.idgroupuser=gu.id  where cn.cnurl=? and qus.isdelete=0  group by qus.tendangnhap",nativeQuery=true)
	List<String> getAll(String url);
	@Query(value = "select qus.tendangnhap from qluser qus  inner join userchucnang ucn on qus.id=ucn.iduser inner join chucnang cn on cn.id=ucn.idcn inner join chucnangcha cna on cna.id=cn.cncha inner join vaitro vt on vt.id=qus.idvaitro  inner join vaitrochucnang vtc on vtc.idvt=vt.id   inner join groupuser gu on gu.id=qus.idgroupuser inner join groupusercn gucn on gucn.idgroupuser=gu.id  where cna.cnurl=? and qus.isdelete=0  group by qus.tendangnhap",nativeQuery=true)
	List<String> getAlla(String url);
}
