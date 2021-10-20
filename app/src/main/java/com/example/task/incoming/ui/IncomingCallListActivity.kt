package com.example.task.incoming.ui

import android.Manifest
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.incoming.R
import com.example.task.incoming.ui.adapter.IncomingCallsListAdapter
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest

class IncomingCallListActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    private lateinit var incomingCallList: RecyclerView

    private lateinit var appSettingsDialog: AppSettingsDialog
    private lateinit var permissionRequest: PermissionRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list)
        incomingCallList = findViewById(R.id.incoming_call_list)

        appSettingsDialog = AppSettingsDialog.Builder(this)
            .setRequestCode(RC_PERMISSIONS)
            .setRationale(R.string.perm_rationale)
            .build()

        permissionRequest = PermissionRequest.Builder(this, RC_PERMISSIONS, *permissions)
            .setRationale(getString(R.string.perm_rationale))
            .setPositiveButtonText("OK")
            .setTheme(R.style.AppTheme)
            .build()

        EasyPermissions.requestPermissions(
            permissionRequest
        )

        val lineDivider = DividerItemDecoration(this, RecyclerView.VERTICAL)
        incomingCallList.addItemDecoration(lineDivider)

        // Get the view model
        val model by viewModels<IncomingCallViewModel>()

        // Specify layout for recycler view
        incomingCallList.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )

        // Observe the model
        model.incomingCalls.observe(this, { calls ->
            // Data bind the recycler view
            incomingCallList.adapter = IncomingCallsListAdapter(calls)
        })
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        // Nothing to do here...
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionDenied(this, *permissions))
            appSettingsDialog.show()
        else
            EasyPermissions.requestPermissions(permissionRequest)
    }

    companion object {
        private const val RC_PERMISSIONS = 42
        private val permissions = arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CALL_LOG
        )
    }
}