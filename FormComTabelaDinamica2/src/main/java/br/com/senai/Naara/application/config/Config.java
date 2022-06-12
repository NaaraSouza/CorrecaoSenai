package br.com.senai.Naara.application.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3) //) // Faces fornece,comportamentos e recursos que são associados ao JSF.
@ApplicationScoped //É usado para indicar que só haverá um objeto da classe anotada com @ApplicationScoped na sua aplicação.
public class Config {
}
