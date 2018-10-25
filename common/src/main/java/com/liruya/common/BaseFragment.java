package com.liruya.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liruya.loaddialog.LoadDialog;

public abstract class BaseFragment extends Fragment
{
    protected final String TAG = this.getClass().getSimpleName();

    private LoadDialog mLoadDialog;

    @Override
    public void onAttach( Context context )
    {
        super.onAttach( context );
    }

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
    {
        View view = inflater.inflate( getLayoutResID(), container, false );

        initView( view );
        return view;
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState )
    {
        super.onActivityCreated( savedInstanceState );
    }

    @Override
    public void onStart()
    {
        super.onStart();
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onStop()
    {
        super.onStop();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    public void showLoadDialog( @StyleRes int theme )
    {
        if ( mLoadDialog == null )
        {
            mLoadDialog = new LoadDialog.Builder( getContext(), theme ).create();
        }
        mLoadDialog.show();
    }

    public void showLoadDialog()
    {
        if ( mLoadDialog == null )
        {
            mLoadDialog = new LoadDialog.Builder( getContext() ).create();
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

    protected abstract void initView( View view );

    protected abstract void initData();

    protected abstract void initEvent();
}
