package com.wyden.nis.core.service.communs;

import java.io.Serializable;

import com.wyden.nis.core.service.communs.interfaces.GenericService;

public abstract class GenericServiceImpl<Entity extends Object, ID extends Serializable> implements GenericService<Entity, ID>{

}
