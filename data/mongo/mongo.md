


use job;
db.createCollection("JobPo");
db.addUser("lts", "lts");
db.auth("lts", "lts");
use
db.JobPo.ensureIndex({"jobId":1},{unique:true});
db.JobPo.ensureIndex({"nodeGroup":1, "taskId":1},{unique:true});
db.JobPo.ensureIndex({"taskTracker":1});
db.JobPo.ensureIndex({"gmtCreate":1});
db.JobPo.ensureIndex({"priority":1});
db.JobPo.ensureIndex({"isRunning":1});
db.JobPo.ensureIndex({"taskTrackerNodeGroup":1, "isRunning":1, "isFinished":1,"priority":1,"gmtCreate":1});


db.createCollection("JobLogPo");
db.addUser("lts", "lts");
db.auth("lts", "lts");

db.JobLogPo.ensureIndex({"jobId":1});
db.JobLogPo.ensureIndex({"nodeGroup":1, "taskId":1});
db.JobLogPo.ensureIndex({"taskTracker":1});
db.JobLogPo.ensureIndex({"gmtCreate":1});
db.JobLogPo.ensureIndex({"priority":1});
db.JobLogPo.ensureIndex({"logType":1});
db.JobLogPo.ensureIndex({"timestamp":1});
db.JobLogPo.ensureIndex({"taskId":1});

