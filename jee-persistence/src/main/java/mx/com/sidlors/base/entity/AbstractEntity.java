package mx.com.sidlors.base.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T> implements Comparable<T>, Serializable {
  private static final long serialVersionUID = -8132633738683047017L;
  public abstract boolean equals( Object obj );
  public abstract int hashCode();
}
