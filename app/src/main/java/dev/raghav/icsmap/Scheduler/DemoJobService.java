// Copyright 2016 Google, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

package dev.raghav.icsmap.Scheduler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/** A very simple JobService that merely stores its result and immediately finishes. */
public class DemoJobService extends JobService {
  @Override
  public boolean onStartJob(@NonNull JobParameters job) {
    Log.i("TAG", "onStartJob called");
    Toast.makeText(this, "ghost working", Toast.LENGTH_SHORT).show();

    Bundle extras = job.getExtras();
    assert extras != null;

    int result = extras.getInt("return");

    CentralContainer.getStore(getApplicationContext()).recordResult(job, result);

    return false; // No more work to do
  }

  @Override
  public boolean onStopJob(@NonNull JobParameters job) {
    return false; // No more work to do
  }
}
