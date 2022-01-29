package com.wang.material.material.exception;

public interface IError {
    java.lang.String getNamespace();

    java.lang.String getErrorCode();

    default java.lang.String getErrorMessage() { /* compiled code */ }

    default java.lang.String getErrorMessage(java.lang.Object... args) { /* compiled code */ }

    default java.lang.String getCanonicalCode() { /* compiled code */ }
}
