
package services.impl;

import java.util.List;
import models.LoaiDep;
import repositories.LoaiDepRepository;
import services.ILoaiDepService;

/**
 *
 * @author homna
 */
public class LoaiDepService implements ILoaiDepService {

    private LoaiDepRepository loaiDepRepository = new LoaiDepRepository();
    
    @Override
    public List<LoaiDep> getAll() {
        return loaiDepRepository.getAll();
    }

    @Override
    public boolean save(LoaiDep ld) {
        return loaiDepRepository.save(ld);
    }

    @Override
    public LoaiDep getObj(String ma) {
        return loaiDepRepository.getObj(ma);
    }
    
}
