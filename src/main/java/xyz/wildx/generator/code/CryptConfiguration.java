package xyz.wildx.generator.code;

import java.util.List;
import java.util.Map;

/**
 * 配置需要加密的表及字段
 *
 * @author liuchenglong
 * @date 2020/02/18 7:08 下午
 */
public class CryptConfiguration {
    /**
     * 配置的待加密表集合
     */
    private Map<String, List<String>> tableList;

    public Map<String, List<String>> getTableList() {
        return tableList;
    }

    public void setTableList(Map<String, List<String>> tableList) {
        this.tableList = tableList;
    }

}
