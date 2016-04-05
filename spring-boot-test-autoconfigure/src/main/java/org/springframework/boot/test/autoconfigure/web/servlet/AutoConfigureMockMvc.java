/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.test.autoconfigure.web.servlet;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * Annotation that can be applied to a test class to enable and configure
 * auto-configuration of {@link MockMvc}.
 *
 * @author Phillip Webb
 * @since 1.4.0
 * @see MockMvcAutoConfiguration
 * @see SpringBootMockMvcBuilderCustomizer
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@ImportAutoConfiguration({ MockMvcAutoConfiguration.class,
		MockMvcWebClientAutoConfiguration.class,
		MockMvcWebDriverAutoConfiguration.class })
@PropertyMapping("spring.test.mockmvc")
public @interface AutoConfigureMockMvc {

	/**
	 * If filters from the application context should be registered with MockMVC. Defaults
	 * to {@code true}.
	 * @return if filters should be added
	 */
	boolean addFilters() default true;

	/**
	 * If {@link MvcResult} information should always be printed after each MockMVC
	 * invocation. Defaults to {@code true}.
	 * @return if result information is always printed
	 */
	boolean alwaysPrint() default true;

	/**
	 * If a {@link WebClient} should be auto-configured when HtmlUnit is on the classpath.
	 * Defaults to {@code true}.
	 * @return if a {@link WebClient} is auto-configured
	 */
	@PropertyMapping("webclient.enabled")
	boolean webClientEnabled() default true;

	/**
	 * If a {@link WebDriver} should be auto-configured when Selenium is on the classpath.
	 * Defaults to {@code true}.
	 * @return if a {@link WebDriver} is auto-configured
	 */
	@PropertyMapping("webdriver.enabled")
	boolean webDriverEnabled() default true;

}