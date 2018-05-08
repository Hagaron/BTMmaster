package com.brotandos.btm

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import org.jetbrains.anko.frameLayout

class MainActivity : AppCompatActivity() {
    private val fragManager = supportFragmentManager
    private val container = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frameLayout { id = container }
        // If there are any instances saved, return
        if (savedInstanceState != null) return
        changeFragment(Frag())
    }


    @SuppressLint("PrivateResource")
    private fun changeFragment(f: Fragment, needToCleanStack: Boolean = false) {
        if (needToCleanStack) clearBackStack()
        fragManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.abc_fade_in,
                        R.anim.abc_fade_out,
                        R.anim.abc_popup_enter,
                        R.anim.abc_popup_exit)
                .replace(container, f)
                .addToBackStack(f::class.simpleName)
                .commit()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (intent != null) checkPermissions()
            else Log.e("MAIN_ACTIVITY", "Intent is null")
        }
    }


    private fun checkPermissions() {
        if (Build.VERSION.SDK_INT < 23) return
        val permission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED)
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
    }


    private fun clearBackStack() {
        if (fragManager.backStackEntryCount == 0) return
        val first = fragManager.getBackStackEntryAt(0)
        fragManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    /**
     * Finish activity when reaching the last fragment.
     * TODO restore data from previous fragments
     */
    override fun onBackPressed() {
        if (fragManager.backStackEntryCount > 1) fragManager.popBackStack()
        else finish()
    }
}