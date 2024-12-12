package com.vlutsenko.framework.config.scope;

import com.vlutsenko.framework.config.annotations.LazyConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import static com.vlutsenko.framework.config.scope.ScopeConstants.WEBDRIVER_SCOPE;

@LazyConfiguration
public class WebDriverBrowserScopePostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(WEBDRIVER_SCOPE, new WebDriverScope());
    }
}
