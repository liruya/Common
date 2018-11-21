package com.liruya.common;

import android.content.Intent;
import android.os.Bundle;

import com.liruya.loaddialog.LoadDialog;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity
{
    protected final String TAG = this.getClass().getSimpleName();

    private LoadDialog mLoadDialog;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( getLayoutResID() );

        Intent intent = getIntent();
        if ( intent != null )
        {
            getIntentData( intent );
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void showLoadDialog( @StyleRes int theme )
    {
        if ( mLoadDialog == null )
        {
            mLoadDialog = new LoadDialog.Builder( this, theme ).setCanceledOnTouchOutside( false ).create();
        }
        mLoadDialog.show();
    }

    public void showLoadDialog()
    {
        if ( mLoadDialog == null )
        {
            mLoadDialog = new LoadDialog.Builder( this ).setCanceledOnTouchOutside( false ).create();
        }
        mLoadDialog.show();
    }

    public void showLoadSuccess()
    {
        if ( mLoadDialog != null && mLoadDialog.isShowing() )
        {
            mLoadDialog.dismiss();
        }
    }

    public void showLoadError( String error )
    {
        if ( mLoadDialog != null && mLoadDialog.isShowing() )
        {
            mLoadDialog.dismiss();
        }
    }

    public void setLoadMessage( String msg )
    {
        if ( mLoadDialog != null )
        {
            mLoadDialog.setText( msg );
        }
    }

    protected abstract @LayoutRes int getLayoutResID();

    protected abstract void getIntentData( @NonNull Intent intent );

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();
}
