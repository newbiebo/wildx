package xyz.wildx.generator.code;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ho.yaml.Yaml;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

/**
 * 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 * Created on 2021/6/7.
 *
 * @author wangbo
 */
@Slf4j
public class MybatisCodeGenerator extends AutoGenerator {

    /***********************************************全局配置*********************************************/
    /***生成文件的作者名（TODO 改为自己的名字）*/
    private static final String AUTHOR = "wangbo";
    /***是否覆盖已有文件，true表示直接覆盖。如果文件已存在则覆盖（TODO 请根据自己需求设置是否需要覆盖的规则!!!）*/
    private static final Boolean FILE_OVERRIDE = true;
    /******************************************** db 配置（TODO 填自己的db配置）***********************************************/
        private static final String DB_URL = "jdbc:mysql://rm-uf63p54fld8f6f2ze6o.mysql.rds.aliyuncs.com:3306/wildx?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true";
        private static final String DB_USERNAME = "wildx_wuchangwei88";
        private static final String DB_PWD = "Wildx_wuchangwei88";

    /***********************************************包配置**********************************************/
    /***自定义包路径（TODO 修改包路径）*/
    private static final String PACKAGE_NAME = "xyz.wildx.generator.temp";
    /***包模块名（不填请设置为null）*/
    private static final String MODULE_NAME = "";
    /**************************************策略配置***********************************************/
    /***逻辑删除字段名配置（所有逻辑删除统一用is_deleted字段名）*/
    private static final String LOGIC_DELETE_FIELD_NAME = "is_deleted";
    // TODO 下列两项配置暂时不用
    //private static final String SUPER_ENTITY_CLASS = "com.baomidou.mybatisplus.samples.generator.common.BaseEntity";
    //private static final String SUPER_CONTROLLER_CLASS = "com.baomidou.ant.common.BaseController";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 判断 table 是否包含设置的逻辑删除字段
     *
     * @param tableInfo               table 信息
     * @param logicDeletePropertyName 设置的逻辑删除字段
     * @return true-是，false-否
     */
    private boolean isLogicDelete(TableInfo tableInfo, String logicDeletePropertyName) {
        List<TableField> fields = tableInfo.getFields();
        return fields.parallelStream().anyMatch((tf) -> tf.getName().equalsIgnoreCase(logicDeletePropertyName));
    }

    @Override
    protected ConfigBuilder pretreatmentConfigBuilder(ConfigBuilder config) {
        if (null != this.injectionConfig) {
            this.injectionConfig.initMap();
            config.setInjectionConfig(this.injectionConfig);
        }

        List<TableInfo> tableList = this.getAllTableInfoList(config);

        for (TableInfo tableInfo : tableList) {
            if (config.getGlobalConfig().isActiveRecord()) {
                tableInfo.setImportPackages(Model.class.getCanonicalName());
            }

            if (tableInfo.isConvert()) {
                tableInfo.setImportPackages(TableName.class.getCanonicalName());
            }

            if (config.getStrategyConfig().getLogicDeleteFieldName() != null
                    && isLogicDelete(tableInfo, config.getStrategyConfig().getLogicDeleteFieldName())) {
                tableInfo.setImportPackages(TableLogic.class.getCanonicalName());
            }

            if (com.baomidou.mybatisplus.core.toolkit.StringUtils.
                    isNotEmpty(config.getStrategyConfig().getVersionFieldName())) {
                tableInfo.setImportPackages(Version.class.getCanonicalName());
            }

            boolean importSerializable = true;
            if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotEmpty(config.getSuperEntityClass())) {
                tableInfo.setImportPackages(config.getSuperEntityClass());
                importSerializable = false;
            }

            if (config.getGlobalConfig().isActiveRecord()) {
                importSerializable = true;
            }

            if (importSerializable) {
                tableInfo.setImportPackages(Serializable.class.getCanonicalName());
            }

            if (config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix()) {
                tableInfo.getFields().stream().filter(field -> "boolean".equalsIgnoreCase(field.getPropertyType())
                        && field.getPropertyName().startsWith("is")).forEach((field) -> {
                    field.setConvert(true);
                    field.setPropertyName(com.baomidou.mybatisplus.core.toolkit.StringUtils.
                            removePrefixAfterPrefixToLower(field.getPropertyName(), 2));
                });
            }
        }

        return config.setTableInfoList(tableList);
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new MybatisCodeGenerator();
        /////////////////////////////////////////////////////////////////////////////////////////
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //当前文件夹
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "\\src\\main\\java");
        log.info(projectPath+"====================================");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        gc.setFileOverride(FILE_OVERRIDE);
        // 开启resultMap（添加xml中映射关系）
        gc.setBaseResultMap(true);
        // XML columList 暂时不用该配置
//        gc.setBaseColumnList(true);
        // 使用java.util.Date
        gc.setDateType(DateType.ONLY_DATE);

        mpg.setGlobalConfig(gc);
        /////////////////////////////////////////////////////////////////////////////////////////
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(DB_PWD);

        mpg.setDataSource(dsc);
        /////////////////////////////////////////////////////////////////////////////////////////
        // 包配置
        final PackageConfig pc = new PackageConfig();
        if (StringUtils.isNotEmpty(MODULE_NAME)) {
            pc.setModuleName(MODULE_NAME);
        }
        pc.setParent(PACKAGE_NAME);

        mpg.setPackageInfo(pc);

        /////////////////////////////////////////////////////////////////////////////////////////
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // 配置需要加密的表及字段
                CryptConfiguration cryptConfiguration = null;
                try {
                    cryptConfiguration =
                            Yaml.loadType(MybatisCodeGenerator.class.getResourceAsStream("/cryptConfig.yml"),
                                    CryptConfiguration.class);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (cryptConfiguration != null && !cryptConfiguration.getTableList().isEmpty()) {
                    Map<String, Object> map = new HashMap<>(16);
                    map.putAll(cryptConfiguration.getTableList());
                    this.setMap(map);
                }
            }
        };

        // 使用freemarker模板引擎
        String templatePath = "/custom-templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "\\src\\main\\resources\\mapper\\" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        /////////////////////////////////////////////////////////////////////////////////////////
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        // 自定义模板配置路径
        templateConfig.setEntity("/custom-templates/entity.java");
        templateConfig.setController("/custom-templates/controller.java");
        templateConfig.setMapper("/custom-templates/mapper.java");
        templateConfig.setService("/custom-templates/service.java");
        templateConfig.setServiceImpl("/custom-templates/serviceImpl.java");
        mpg.setTemplate(templateConfig);

        /////////////////////////////////////////////////////////////////////////////////////////
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass(SUPER_ENTITY_CLASS);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass(SUPER_CONTROLLER_CLASS);
        strategy.setInclude(scanner("表名，如果是多个表请用英文逗号分割").split(","));
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        // Boolean字段生成实体类时移除is前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setLogicDeleteFieldName(LOGIC_DELETE_FIELD_NAME);
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        // 如果模板引擎是 freemarker, 则设置对应引擎配置
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
