package org.dromara.workflow.flowable.config;

import jakarta.annotation.Resource;
import org.dromara.common.core.domain.R;
import org.dromara.workflow.mapper.WfModelKey;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class WorkFlowKeysConfig implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.setBeanNameGenerator(new AnnotationBeanNameGenerator());
        scanner.addIncludeFilter(new AnnotationTypeFilter(WfModelKey.class));
        scanner.scan("org.dromara.workflow");
    }

    /**
     * 通过注解获取模型Key 列表
     * @param applicationContext
     * @return
     */
    public List<Map<String,String>> getKeys(ApplicationContext applicationContext) {
        Map<String, Object> bean = applicationContext.getBeansWithAnnotation(WfModelKey.class);
        List<Map<String,String>> keys = new ArrayList<>();
        bean.forEach((k, v) -> {
            Class<?> clazz = AopUtils.getTargetClass(v);
            WfModelKey key = clazz.getDeclaredAnnotation(WfModelKey.class);
            keys.add(Map.of("key",key.key()));
        });
        return keys;
    }
}
